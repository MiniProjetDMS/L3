
package packages;

import java.util.Date;


public class Fiche_medical{

	private int id_pat;
	private Date date_consult;
	private String schema_dentaire;
	public Fiche_medical(int id_pat,Date date_consult,String schema_dentaire)
	{
     this.id_pat=id_pat;
     this.date_consult=date_consult;
     this.schema_dentaire=schema_dentaire;
	}

	public int getId_pat(){
	       return id_pat;
                            }
    public void setId_pat(int id_pat){
	        this.id_pat=id_pat;
                            }

    public Date getDate_consult(){
	       return date_consult;
                            }
    public void setDate_consult(Date date_consult){
	        this.date_consult=date_consult;
                            }

    public String getSchema_dentaire(){
	       return schema_dentaire;
                            }
    public void setSchema_dentaire(String schema_dentaire){
	        this.schema_dentaire=schema_dentaire;
                            }

}

