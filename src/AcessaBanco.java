
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Henrique Becker
 */
public class AcessaBanco {
    private class ApartamentoDeserealized implements JsonDeserializer<Apartamento>{

        @Override
        public Apartamento deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
            JsonObject jsonObject = je.getAsJsonObject();
            JsonElement tipoLuminaria = jsonObject.get("tipoLuminaria");
            if(tipoLuminaria != null){
                return jdc.deserialize(jsonObject, 
                        ApartamentoLuxo.class);
            }else{
                return jdc.deserialize(jsonObject, 
                        ApartamentoPadrao.class);
            }
        }
    
}

    private static AcessaBanco acessaBanco;
    private ArrayList<Condominio> condominios = new ArrayList<Condominio>();

    private AcessaBanco() {
    }

    public static AcessaBanco getAcesso() {
        if (acessaBanco == null) {
            acessaBanco = new AcessaBanco();
        }
        return acessaBanco;
    }

    public ArrayList<Condominio> getCondominios() {
        if (this.condominios.size() == 0) {
            BufferedReader buf = null;
            try {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder
                        .registerTypeAdapter(Apartamento.class, new ApartamentoDeserealized())
                        .create();
                InputStream is = new FileInputStream("db.txt");
                buf = new BufferedReader(new InputStreamReader(is));
                String line = buf.readLine();
                StringBuilder sb = new StringBuilder();
                while (line != null) {
                    sb.append(line).append("\n");
                    line = buf.readLine();
                }
                this.condominios = gson.fromJson(sb.toString(), (new TypeToken<ArrayList<Condominio>>() {}).getType());
            } catch (Exception e) {
                this.condominios = new ArrayList<>();
            } finally {
                try {
                    // Close the writer regardless of what happens...
                    buf.close();
                } catch (IOException e) {
                }
            }
        }
        return this.condominios;
    }

    public void addCondominio(Condominio condominio) {
        if(this.condominios == null){
            this.condominios = new ArrayList<Condominio>();
        }
        this.condominios.add(condominio);
        this.salvarCondominios(condominios);
    }

    public void salvarCondominios(ArrayList<Condominio> condominios) {
        if(condominios != null){
            this.condominios = condominios;
        }else if(this.condominios == null || this.condominios.isEmpty()){
            return;
        }
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String jsonStr = gson.toJson(this.condominios, this.condominios.getClass());
        BufferedWriter writer = null;
        try {
            File db = new File("db.txt");

            writer = new BufferedWriter(new FileWriter(db));
            writer.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (IOException e) {
            }
        }
    }
}
