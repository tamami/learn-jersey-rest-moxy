package lab.aikibo.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sppt {
  private String nop;
  private String nama;
  private long pbb;

  public Sppt() {}

  public Sppt(String nop, String nama, long pbb) {
    this.nop = nop;
    this.nama = nama;
    this.pbb = pbb;
  }

  public String getNop() {
    return nop;
  }

  public void setNop(String nop) {
    this.nop = nop;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public long getPbb() {
    return pbb;
  }

  public void setPbb(long pbb) {
    this.pbb = pbb;
  }
}
