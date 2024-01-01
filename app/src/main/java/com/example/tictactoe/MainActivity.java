package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> combinationList= new ArrayList<>();
    private int[] boxPositions= {0,0,0,0,0,0,0,0,0};
    private int playerTurn =1;
    private int totalSelectedBoxes =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition]=playerTurn;

        if(playerTurn==1){
            imageView.setImageResource(R.drawable.ximage);

            if(checkResults()){
                ResultDialog resultDialog= new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()+ "is a winner!", MainActivity.this);
                //pending
            }
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn=currentPlayerTurn;
        if(playerTurn==1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }
        else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResults(){
        boolean response= false;
        for(int i=0; i<combinationList.size(); i++){
            final int[] combination=combinationList.get(i);

            if(boxPositions[combination[0]]==playerTurn && boxPositions[combination[1]]==playerTurn &&
            boxPositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxPositions[boxPosition]==0){
            response = true;
        }
        return response;
    }

    public void restartMatch(){
        boxPositions= new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalSelectedBoxes=1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}