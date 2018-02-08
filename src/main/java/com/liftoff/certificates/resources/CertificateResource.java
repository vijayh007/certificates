package com.liftoff.certificates.resources;

import com.liftoff.certificates.dao.CertificatesDetailsDaoImpl;
import com.liftoff.certificates.domain.CertificatesRequest;
import com.liftoff.certificates.entity.CertificatesDetails;
import com.liftoff.certificates.service.CertificateService;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by vijay.hathimare on 2/8/18.
 */
@Path("/certificates")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CertificateResource {
    CertificateService certificateService = null;
    public CertificateResource(){
        certificateService = new CertificateService();
    }

    @Path("/create_certificates")
    @POST
    public Map<String, String> createCertificates(CertificatesRequest certificatesRequest){
        Map<String, String> response = null;
        response = certificateService.createCertificate(certificatesRequest);
        return response;
    }


    @Path("/get_certificates_by_userid")
    @GET
    public List<CertificatesDetails> getCertificateByUserId(@QueryParam("userId") String userId){
        List<CertificatesDetails>  certificatesDetailses = null;
        certificatesDetailses = certificateService.getCertificates(userId);
        return certificatesDetailses;
    }

    @Path("/get_certificates_by_courseid")
    @GET
    public List<CertificatesDetails> getCertificateByCourseId(@QueryParam("courseId") String courseId){
        List<CertificatesDetails>  certificatesDetailses = null;
        certificatesDetailses = certificateService.getCertificatesByCourseId(courseId);
        return certificatesDetailses;
    }

    @Path("/get_certificates_by_dates")
    @GET
    public List<CertificatesDetails> getCertificatesBetweenDates(@QueryParam("fromDate") String fromDate,
                                                                 @QueryParam("toDate") String toDate){
        List<CertificatesDetails>  certificatesDetailses;
        certificatesDetailses = certificateService.getCertificatesBetweenDates(fromDate, toDate);
        return certificatesDetailses;
    }
}
