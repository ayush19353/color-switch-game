package application;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.*;
import java.util.ArrayList;

public class Datbas implements Serializable {
private static final long serialVersionUID=42L;
private static Datbas d;
private ArrayList<DatTab> datafiles;
public Datbas()
{
	
datafiles=new ArrayList<DatTab>();}
public void addData(DatTab d) {
    datafiles.add(d);
}

public void removeData(DatTab d) {
   	datafiles.remove(d);
}

public ArrayList<DatTab> getdatafiles() {
    return datafiles;
}



}
