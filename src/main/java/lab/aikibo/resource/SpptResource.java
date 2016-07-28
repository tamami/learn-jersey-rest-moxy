package lab.aikibo.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lab.aikibo.entity.Sppt;

@Path("/sppt/{nop}/{thn}")
public class SpptResource {
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Sppt getSppt(@PathParam("nop") String nop, @PathParam("thn") String thn) {
    return new Sppt(nop, "tamami", 10000);
  }

  /*
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public String postPembayaran(PembayaranSppt byr) {
    if(byr.isOk()) {
      return "OK";
    }
  }
  }
  */
}
