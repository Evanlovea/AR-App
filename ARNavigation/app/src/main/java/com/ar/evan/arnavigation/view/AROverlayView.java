package com.ar.evan.arnavigation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.Location;
import android.opengl.Matrix;
import android.view.View;

import com.ar.evan.arnavigation.helper.LocationHelper;
import com.ar.evan.arnavigation.model.ARPoint;
import com.ar.evan.arnavigation.model.LocationInfoBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 在相机上面设置浮层，显示所设置的ARPoints以实现AR效果
 */
public class AROverlayView extends View {

    Context context;
    private float[] rotatedProjectionMatrix = new float[16];
    private Location currentLocation;
    private List<ARPoint> arPoints;
    List<LocationInfoBean>locationInfoBeanList=new ArrayList<>();
    LocationInfoBean locationInfoBean=new LocationInfoBean();


    public AROverlayView(Context context,List<ARPoint> points) {
        super(context);
        arPoints=new ArrayList<ARPoint>();
        this.context = context;
       /* for(ARPoint arPoint:points){
            arPoints=new ArrayList<ARPoint>();
            arPoints.add(arPoint);
        }*/
       arPoints.addAll(points);
    /*    //Demo points
            arPoints = new ArrayList<ARPoint>() {{
            add(new ARPoint("Sun Wheel",
                    35.747,
                    114.29745, 0));
            add(new ARPoint("Linh Ung Pagoda", 36,
                    115, 1.2));
            add(new ARPoint("恭喜发财", 35.747,
                    114.29745, 10));
            add(new ARPoint("哈哈哈", 116.321481
                    ,39.978437, 1));
        }};*/

    }


    public void updateRotatedProjectionMatrix(float[] rotatedProjectionMatrix) {
        this.rotatedProjectionMatrix = rotatedProjectionMatrix;
        this.invalidate();
    }

    public void updateCurrentLocation(Location currentLocation){
        this.currentLocation = currentLocation;
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (currentLocation == null) {
            return;
        }

        final int radius = 30;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        paint.setTextSize(60);

        for (int i = 0; i < arPoints.size(); i ++) {
            float[] currentLocationInECEF = LocationHelper.WSG84toECEF(currentLocation);
            float[] pointInECEF = LocationHelper.WSG84toECEF(arPoints.get(i).getLocation());
            float[] pointInENU = LocationHelper.ECEFtoENU(currentLocation, currentLocationInECEF, pointInECEF);

            float[] cameraCoordinateVector = new float[4];
            Matrix.multiplyMV(cameraCoordinateVector, 0, rotatedProjectionMatrix, 0, pointInENU, 0);

            // cameraCoordinateVector[2] is z, that always less than 0 to display on right position
            // if z > 0, the point will display on the opposite
            if (cameraCoordinateVector[2] < 0) {
                float x  = (0.5f + cameraCoordinateVector[0]/cameraCoordinateVector[3]) * canvas.getWidth();
                float y = (0.5f - cameraCoordinateVector[1]/cameraCoordinateVector[3]) * canvas.getHeight();

                canvas.drawCircle(x, y, radius, paint);
                canvas.drawText(arPoints.get(i).getName(), x - (30 * arPoints.get(i).getName().length() / 2), y - 80, paint);
            }
        }
    }
}
