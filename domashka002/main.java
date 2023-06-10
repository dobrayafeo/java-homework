import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {

        // Задание 1: Формирование части WHERE запроса
        String sqlQuery = "select * from students where ";
        String jsonParams = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";

        JSONObject params = new JSONObject(jsonParams);

        StringBuilder whereClause = new StringBuilder();

        for (String key : params.keySet()) {
            Object value = params.get(key);
            if (value != null && !value.toString().equals("null")) {
                if (whereClause.length() > 0) {
                    whereClause.append(" AND ");
                }
                whereClause.append(key).append(" = '").append(value).append("'");
            }
        }

        sqlQuery += whereClause.toString();
        System.out.println(sqlQuery);

        // Задание 2: Распарсинг JSON и формирование строк с использованием StringBuilder
        String jsonString = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String surname = jsonObject.getString("фамилия");
                String grade = jsonObject.getString("оценка");
                String subject = jsonObject.getString("предмет");

                stringBuilder.append("Студент ")
                        .append(surname)
                        .append(" получил ")
                        .append(grade)
                        .append(" по предмету ")
                        .append(subject)
                        .append(".\n");
            }

            System.out.println(stringBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
