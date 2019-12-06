package com.example.piggiesteam4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GridSizeActivity extends AppCompatActivity {

    int selectedSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_size);
    }

    /**
     * Sets what size to switch to.
     * @param v View
     */
    public void switchSize(View v){
        Button button = (Button) v;
        Button confirm = (Button) findViewById(R.id.confirmButtonSize);
        String text = button.getText().toString().trim();
        switch (text){
            case "5x5":
                selectedSize = 5;
                break;
            case "6x6":
                selectedSize = 6;
                break;
            case "7x7":
                selectedSize =7;
                break;
            default:
                throw new AssertionError("Unexpected size");
        }//switch
        confirm.setEnabled(true);
    }//switchSize

    /**
     * Starts the game with the selected size, will replace the current game.
     * @param v View
     */
    public void confirmNewGridSize(View v){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("size", selectedSize);
        setResult(RESULT_OK, intent);
    }//confirmNewGridSize
}//GridSizeActivity
