package com.wordpress.dhruvapandey.yourmate;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView replyText;
    EditText inputText;
    Button talkButton;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replyText = (TextView) findViewById(R.id.replyText);
        inputText = (EditText) findViewById(R.id.inputText);
        talkButton = (Button) findViewById(R.id.talkButton);

        replyText.setText("Hey use Text box then press button to have conversation with me");
        //ConvertTextToSpeech();

        talkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput;
                String userOutput;
                userInput = inputText.getText().toString();

                // Read From File
                String lifeQuote = ReadLife();
                String loveQuote = ReadLove();
                String sexQuote = ReadSex();
                String howAreYou = ReadHowAreYou();
                String jokeText = ReadJoke();
                String howOldAreYou = ReadHowOldAreYou();
                String randomText = ReadRandom();
                //
                boolean foundLife = userInput.contains("life");
                boolean foundLove = userInput.contains("love");
                boolean foundSex = userInput.contains("sex");
                boolean foundHrU = userInput.contains("how are you");
                boolean foundJokeTxt = userInput.contains("joke");
                boolean foundHowOld = userInput.contains("how old");

                if (foundHowOld) replyText.setText(howOldAreYou);
                else if (foundJokeTxt) replyText.setText(jokeText);
                else if (foundHrU) replyText.setText(howAreYou);
                else if (foundSex) replyText.setText(sexQuote);
                else if (foundLove) replyText.setText(loveQuote);
                else if (foundLife) replyText.setText(lifeQuote);
                else replyText.setText(randomText);

                inputText.setText("");

                foundLife = false;
                foundLove = false;
                foundSex =  false;
                foundHrU =  false;
                foundJokeTxt = false;
                foundHowOld =false;

                tts=new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        // TODO Auto-generated method stub
                        if(status == TextToSpeech.SUCCESS){
                            int result=tts.setLanguage(Locale.US);
                            if(result==TextToSpeech.LANG_MISSING_DATA ||
                                    result==TextToSpeech.LANG_NOT_SUPPORTED){
                                Log.e("error", "This Language is not supported");
                            }
                            else{
                                ConvertTextToSpeech();
                            }
                        }
                        else
                            Log.e("error", "Initilization Failed!");
                    }
                });

            }
        });
    }

    // Read fromt he txt files
    private String ReadRandom() {
        String rndTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("Random.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 9) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
                //Log.d("DHRUVA",  i +line);
                //Log.d("PANDEY",  randVal +line);
            }
            rndTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rndTxt;

    }

    private String ReadHowOldAreYou() {
        String howOldTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("hwOldAreYou.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 5) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
                Log.d("DHRUVA",  i +line);
                Log.d("PANDEY",  randVal +line);
            }
            howOldTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return howOldTxt;
    }

    private String ReadJoke() {
        String jokeTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("Joke.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 9) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
                //Log.d("DHRUVA", "i"+" randVal"+line);
            }
            jokeTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return jokeTxt;
    }

    private String ReadHowAreYou() {
        String hruTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("howAreYou.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 29) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
            }
            hruTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return hruTxt;
    }

    private String ReadSex() {
        String sexTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("Sex.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 14) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
            }
            sexTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sexTxt;
    }

    private String ReadLove() {
        String loveTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("Love.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 39) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
            }
            loveTxt = line;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return loveTxt;
    }

    private String ReadLife() {
        String lifeTxt = "";
        BufferedReader reader;
        int i = 0;

        try {
            InputStream file = getAssets().open("Life.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            int randVal ;
            randVal = (int) ((Math.random() * 39) + 1);
            while(i <= randVal){
                i++;
                line = reader.readLine();
            }
            lifeTxt = line;

        } catch (IOException ex) {
             ex.printStackTrace();
        }
        return lifeTxt;
    }

    private void ConvertTextToSpeech() {
        // TODO Auto-generated method stub
        String text = replyText.getText().toString();
        if(text==null||"".equals(text))
        {
            text = "Content not available";
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }else
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

}
