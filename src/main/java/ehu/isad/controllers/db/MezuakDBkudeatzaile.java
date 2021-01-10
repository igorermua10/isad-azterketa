package ehu.isad.controllers.db;

import ehu.isad.Mezuak;
import ehu.isad.model.ProbaModel;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MezuakDBkudeatzaile {

    private static final MezuakDBkudeatzaile instance = new MezuakDBkudeatzaile();
    private static final DBKudeatzaile dbcontroller = DBKudeatzaile.getController();

    private MezuakDBkudeatzaile() {}

    public static MezuakDBkudeatzaile getInstance() {
        return instance;
    }


    public void gordeDatuBasean(ObservableList<Mezuak> lista) {
        String query1 = "Delete from DirectMessage";
        DBKudeatzaile.getController().execSQL(query1);
        for (Mezuak mezua : lista) {
            query1 = "insert into DirectMessage(fromUser,toUser,message) values('" + mezua.getNork() + "','" + mezua.getNori() + "','" + mezua.getMezua() + "');";
            System.out.println(query1);
            DBKudeatzaile.getController().execSQL(query1);
        }
    }

    public List<Mezuak> getFromDB(){
        String query2 = "SELECT * FROM DirectMessage;";
        List<Mezuak> list = new ArrayList<>();
        ResultSet rs = dbcontroller.execSQL(query2);
        try {
            while (rs.next()) {
                String fromUser = rs.getString("fromUser");
                String toUser = rs.getString("toUser");
                String message=rs.getString("message");
                list.add(new Mezuak(fromUser,toUser,message));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }

}
