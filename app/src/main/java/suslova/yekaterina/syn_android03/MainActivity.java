package suslova.yekaterina.syn_android03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    // Локальные переменные для доступа к компонентам окна
    private EditText editText;
    private CheckBox checkBox;
    private CheckBox checkBox3;
    private RadioGroup radioGroup;
    private RadioButton selectRadioButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация переменных доступа к компонентам окна
        editText =   findViewById(R.id.editText);
        checkBox =   findViewById(R.id.checkBox);
        checkBox3 =   findViewById(R.id.checkBox3);
        radioGroup = findViewById(R.id.radioGroup);
        spinner =    findViewById(R.id.spinner);
    }

    // МЕТОД ДЛЯ КНОПКИ "ИТОГО"
    public void onInfo(View v) {
        // Создание второго окна
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);


        selectRadioButton = findViewById(radioGroup.getCheckedRadioButtonId());

        // Подготовка параметров для второго окна
        intent.putExtra("fio", editText.getText().toString());
        intent.putExtra("gender", checkBox.isChecked() ? getString(R.string.Мужчина) : getString(R.string.Женщина));
        intent.putExtra("edu", selectRadioButton.getText());
        intent.putExtra("country", spinner.getSelectedItem().toString());

        // Запуск второго окна
        startActivity(intent);
    }

}
