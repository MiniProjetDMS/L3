
package packages;

import java.util.Date;

 public class Ordonnance{

 	private String id_ord;
    private String list_med;
    private Date date_ord;
      public Ordonnance(String id_ord,String list_med,Date date_ord)
      {
       this.id_ord=id_ord;
       this.list_med=list_med;
       this.date_ord=date_ord;
      }
 }