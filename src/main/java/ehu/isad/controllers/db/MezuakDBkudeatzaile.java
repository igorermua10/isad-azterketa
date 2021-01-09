package ehu.isad.controllers.db;

import ehu.isad.Mezuak;
import ehu.isad.model.ProbaModel;

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

    public void addToDB(){
        String query = "INSERT INTO xxxx(xx,xx,xx) VALUES ('xx','xx','xx')";
        dbcontroller.execSQL(query);
    }

    public List<Mezuak> getFromDB(){
        String query = "SELECT fromUser,toUser,message FROM DirectMessage;";
        List<Mezuak> list = new ArrayList<>();
        ResultSet rs = dbcontroller.execSQL(query);
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
