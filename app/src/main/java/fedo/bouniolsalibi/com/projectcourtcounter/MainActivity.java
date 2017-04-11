package fedo.bouniolsalibi.com.projectcourtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score_team_A = 0;
    int score_team_B = 0;

    String STATE_SCORE_A = "save_Score_team_A";
    String STATE_SCORE_B = "save_Score_team_B";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayScoreA(score_team_A);
        displayScoreB(score_team_B);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_A, score_team_A);
        outState.putInt(STATE_SCORE_B, score_team_B);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        score_team_A = savedInstanceState.getInt(STATE_SCORE_A);
        score_team_B = savedInstanceState.getInt(STATE_SCORE_B);
        displayScoreA(score_team_A);
        displayScoreB(score_team_B);
    }

    public void displayScoreA(int score) {
        TextView scoreViewA = (TextView) findViewById(R.id.score_team_A);
        scoreViewA.setText(String.valueOf(score));
    }

    public void displayScoreB(int score) {
        TextView scoreViewB = (TextView) findViewById(R.id.score_team_B);
        scoreViewB.setText(String.valueOf(score));
    }

    public void point(View view) {
        switch (view.getId()) {
            case R.id.tryA:
                score_team_A += 5;
                break;
            case R.id.penaltyA:
                score_team_A += 3;
                break;
            case R.id.conversionA:
                score_team_A += 2;
                break;
            case R.id.dropA:
                score_team_A += 3;
                break;
            case R.id.tryB:
                score_team_B += 5;
                break;
            case R.id.penaltyB:
                score_team_B += 3;
                break;
            case R.id.conversionB:
                score_team_B += 2;
                break;
            case R.id.dropB:
                score_team_B += 3;
                break;
        }
        displayScoreA(score_team_A);
        displayScoreB(score_team_B);
    }

    public void result(View view) {
        String scoreMessage = "";

        if (score_team_A > score_team_B) {
            scoreMessage = getResources().getString(R.string.team_A) + " " + " won with " + score_team_A + " points.";
        }
        if (score_team_A < score_team_B) {
            scoreMessage = getResources().getString(R.string.team_B) + " " + " won with " + score_team_B + " points.";
        }
        if (score_team_A == score_team_B) {
            scoreMessage = "Draw! " + score_team_A + " points for both teams.";
        }
        Toast.makeText(this, scoreMessage, Toast.LENGTH_LONG).show();
    }

    public void reset(View view) {
        score_team_A = 0;
        score_team_B = 0;
        displayScoreA(score_team_A);
        displayScoreB(score_team_B);
    }
}
