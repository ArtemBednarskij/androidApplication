//package com.example.inreal;
//
//import android.app.Activity;
//import android.app.ActivityManager;
//import android.content.Context;
//import android.content.Intent;
//import android.os.Build;
//import android.os.Build.VERSION_CODES;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.Gravity;
//import android.view.MotionEvent;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
////import com.google.ar.core.Anchor;
////import com.google.ar.core.HitResult;
////import com.google.ar.core.Plane;
////import com.google.ar.sceneform.AnchorNode;
////import com.google.ar.sceneform.rendering.ModelRenderable;
////import com.google.ar.sceneform.ux.ArFragment;
////import com.google.ar.sceneform.ux.TransformableNode;
//
///**
// * This is an example activity that uses the Sceneform UX package to make common AR tasks easier.
// */
//public class ARfoundtaion extends AppCompatActivity {
//    public static final String EXTRA_ID = "id";
//    public static final String EXTRA_CATEGORY = "Food or Drink";
//    private static final String TAG = ARfoundtaion.class.getSimpleName();
//    private static final double MIN_OPENGL_VERSION = 3.0;
//
//    private ArFragment arFragment;
//    private ModelRenderable renderableFoodOrDrink;
//
//    public static int rawFoodOrDrink;
//
//    @Override
//    @SuppressWarnings({"AndroidApiChecker", "FutureReturnValueIgnored"})
//    // CompletableFuture requires api level 24
//    // FutureReturnValueIgnored is not valid
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        if (!checkIsSupportedDeviceOrFinish(this)) {
//            return;
//        }
//
//        setContentView(R.layout.activity_a_rfoundtaion);
//        Intent intent = getIntent();
//        int id = intent.getIntExtra(EXTRA_ID, 0);
//        String category = intent.getStringExtra(EXTRA_CATEGORY);
//
//        if (category.equals("Drink")) {
//            rawFoodOrDrink = R.raw.coffee;
//        } else if (category.equals("Food")) {
//            switch (id) {
//                case 0:
//                    rawFoodOrDrink = R.raw.cheeseburger;
//                    break;
//                case 1:
//                    rawFoodOrDrink = R.raw.tom_yam;
//                    break;
//                case 2:
//                    rawFoodOrDrink = R.raw.pizza;
//                    break;
//            }
//        }
//
//        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
//
//        // When you build a Renderable, Sceneform loads its resources in the background while returning
//        // a CompletableFuture. Call thenAccept(), handle(), or check isDone() before calling get().
//        ModelRenderable.builder()
//                .setSource(this, rawFoodOrDrink)
//                .build()
//                .thenAccept(renderable -> renderableFoodOrDrink = renderable)
//                .exceptionally(
//                        throwable -> {
//                            Toast toast =
//                                    Toast.makeText(this, "Unable to load andy renderable", Toast.LENGTH_LONG);
//                            toast.setGravity(Gravity.CENTER, 0, 0);
//                            toast.show();
//                            return null;
//                        });
//
//        arFragment.setOnTapArPlaneListener(
//                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
//                    if (renderableFoodOrDrink == null) {
//                        return;
//                    }
//
//                    // Create the Anchor.
//                    Anchor anchor = hitResult.createAnchor();
//                    AnchorNode anchorNode = new AnchorNode(anchor);
//                    anchorNode.setParent(arFragment.getArSceneView().getScene());
//
//                    // Create the transformable andy and add it to the anchor.
//                    TransformableNode andy = new TransformableNode(arFragment.getTransformationSystem());
//                    andy.setParent(anchorNode);
//                    andy.setRenderable(renderableFoodOrDrink);
//                    andy.select();
//                });
//    }
//
//    /**
//     * Returns false and displays an error message if Sceneform can not run, true if Sceneform can run
//     * on this device.
//     *
//     * <p>Sceneform requires Android N on the device as well as OpenGL 3.0 capabilities.
//     *
//     * <p>Finishes the activity if Sceneform can not run
//     */
//    public static boolean checkIsSupportedDeviceOrFinish(final Activity activity) {
//        if (Build.VERSION.SDK_INT < VERSION_CODES.N) {
//            Log.e(TAG, "Sceneform requires Android N or later");
//            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show();
//            activity.finish();
//            return false;
//        }
//        String openGlVersionString =
//                ((ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE))
//                        .getDeviceConfigurationInfo()
//                        .getGlEsVersion();
//        if (Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
//            Log.e(TAG, "Sceneform requires OpenGL ES 3.0 later");
//            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
//                    .show();
//            activity.finish();
//            return false;
//        }
//        return true;
//    }
//}