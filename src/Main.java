import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        InBean ib = new InBean();
        ib.setTorihikisakiName("セントラル商会");
        ib.setTorihikiDate( LocalDate.of(2018, 5, 2) );
        ib.setGoukei(400);

        ib.getLines().add(  new InLineBean("消しゴム",1,100) );
        ib.getLines().add(  new InLineBean("鉛筆",20,300) );

        OutBean ob = tenki( ib );
        System.out.println( ob.toString() );
    }

    @Override
    public String toString() {
        return "Main []";
    }

    static OutBean tenki( InBean ib)
    {

//    	1.日付を読む
        LocalDate date = ib.getTorihikiDate();

//    	2.日付を該当項目に記入
        OutBean ob = new OutBean();
        ob.setTorihikiDate(date);

//    	3.取引先を読む
        String torihiki = ib.getTorihikisakiName();

//    	4.取引先を該当項目に記入
        ob.setTorihikisakiName(torihiki);

//      5.表が書ける空間の確認
//      6.なるべく大きい四角を書く
        List<OutLineBean> list = ob.getLines();

//      7.四角を横に５等分する
//    	8.商品名・数量・金額の見出しを最上段に記入

        for (InLineBean i : ib.getLines())
        {
//        	9.一番上から商品名・数量・金額を読む
            String shouhinName = i.getShouhinName();
            int	suuryo = i.getSuuryo();
            int	kingaku = i.getKingaku();

//        	10.商品名・数量・金額を表の上から記入
            OutLineBean olb = new OutLineBean();

            olb.setShouhinName(shouhinName);
            olb.setSuuryo(suuryo);
            olb.setKingaku(kingaku);

            list.add(olb);
        }

//    	11.表が全て埋まるごとに改ページし、1～10を繰り返す

//    	12.合計金額を読む
        int goukei = ib.getGoukei();

//    	13.合計金額を該当項目に記入
        ob.setGoukei(goukei);

        return ob;
    }

}
//------------------------------------
class InBean
{
    private LocalDate 			torihikiDate;
    private String	  			torihikisakiName;
    private int		  			goukei;
    private List<InLineBean> 	lines= new ArrayList<InLineBean>();

    public LocalDate getTorihikiDate() {
        return torihikiDate;
    }
    public void setTorihikiDate(LocalDate torihikiDate) {
        this.torihikiDate = torihikiDate;
    }
    public String getTorihikisakiName() {
        return torihikisakiName;
    }
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }
    public int getGoukei() {
        return goukei;
    }
    public void setGoukei(int goukei) {
        this.goukei = goukei;
    }
    public List<InLineBean> getLines() {
        return lines;
    }



}
class InLineBean
{
    private String shouhinName;
    private int		suuryo;
    private int		kingaku;



    public InLineBean(String shouhinName, int suuryo, int kingaku) {
        super();
        this.shouhinName = shouhinName;
        this.suuryo = suuryo;
        this.kingaku = kingaku;
    }
    public String getShouhinName() {
        return shouhinName;
    }
    public void setShouhinName(String shouhinName) {
        this.shouhinName = shouhinName;
    }
    public int getSuuryo() {
        return suuryo;
    }
    public void setSuuryo(int suuryo) {
        this.suuryo = suuryo;
    }
    public int getKingaku() {
        return kingaku;
    }
    public void setKingaku(int kingaku) {
        this.kingaku = kingaku;
    }


}
//------------------------------------
class OutBean
{
  private LocalDate 			torihikiDate;
  private String	  			torihikisakiName;
  private int		  			goukei;
  private List<OutLineBean> 	lines= new ArrayList<OutLineBean>();

    public LocalDate getTorihikiDate() {
        return torihikiDate;
    }
    public void setTorihikiDate(LocalDate torihikiDate) {
        this.torihikiDate = torihikiDate;
    }
    public String getTorihikisakiName() {
        return torihikisakiName;
    }
    public void setTorihikisakiName(String torihikisakiName) {
        this.torihikisakiName = torihikisakiName;
    }
    public int getGoukei() {
        return goukei;
    }
    public void setGoukei(int goukei) {
        this.goukei = goukei;
    }
    public List<OutLineBean> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "OutBean [torihikiDate=" + torihikiDate + ", torihikisakiName=" + torihikisakiName + ", goukei=" + goukei
                + ", lines=" + lines + "]";
    }

}
//------------------------------------
class OutLineBean
{
  private String shouhinName;
  private int		suuryo;
  private int		kingaku;
    public String getShouhinName() {
        return shouhinName;
    }
    public void setShouhinName(String shouhinName) {
        this.shouhinName = shouhinName;
    }
    public int getSuuryo() {
        return suuryo;
    }
    public void setSuuryo(int suuryo) {
        this.suuryo = suuryo;
    }
    public int getKingaku() {
        return kingaku;
    }
    public void setKingaku(int kingaku) {
        this.kingaku = kingaku;
    }

    @Override
    public String toString() {
        return "OutLineBean [shouhinName=" + shouhinName + ", suuryo=" + suuryo + ", kingaku=" + kingaku + "]";
    }


}