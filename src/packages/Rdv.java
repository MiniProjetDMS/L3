
package packages;

import java.util.Date;


public class Rdv{

	private Date date_rdv;
    private String heure_rdv;
    private String id_rdv;
    private int num_rdv;
    private String info_pat;
    private int id_pat;

    public Rdv(Date date_rdv,String heure_rdv,String id_rdv,int num_rdv,String info_pat, int id_pat)
    {
    this.date_rdv=date_rdv;
    this.heure_rdv=heure_rdv;
    this.id_rdv=id_rdv;
    this.num_rdv=num_rdv;
    this.info_pat=info_pat;
    this.id_pat=id_pat;
    }
    
    public Date getDate_rdv(){
	       return date_rdv;
                            }
    public void setDate_rdv(Date date_rdv){
	        this.date_rdv=date_rdv;
                            }

    public String getHeure_rdv(){
	       return heure_rdv;
                            }
    public void setHeure_rdv(String heure_rdv){
	        this.heure_rdv=heure_rdv;
                            }
    
    public String getId_rdv(){
	       return id_rdv;
                            }
    public void setDate_rdv(String id_rdv){
	        this.id_rdv=id_rdv;
                            }

    public int getNum_rdv(){
	       return num_rdv;
                            }
    public void setNum_rdv(int num_rdv){
	        this.num_rdv=num_rdv;
                            }

    public String getInfo_pat(){
	       return info_pat;
                            }
    public void setInfo_pat(String info_pat){
	        this.info_pat=info_pat;
                            }

    public int getId_pat(){
	       return id_pat;
                            }
    public void setId_pat(int id_pat){
	        this.id_pat=id_pat;
                            }
}

