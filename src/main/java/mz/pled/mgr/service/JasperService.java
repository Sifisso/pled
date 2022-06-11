package mz.pled.mgr.service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Service
public class JasperService {

    private static final String JASPER_DIRECTORIO = "classpath:report/";
    private static final String JASPER_PREFIXO = "pled";
    private static final String JASPER_SUFIXO = ".jasper";

    @Autowired
    private Connection connection;

    private Map<String,Object> params = new HashMap<>();

    public void addParams(String key, Object value){
        this.params.put(key, value);
    }

    public byte[] exportarPDF(String relatorio){

        byte[] bytes = null;

        try {

            File file = ResourceUtils.getFile(JASPER_DIRECTORIO.concat(JASPER_PREFIXO).concat(relatorio).concat(JASPER_SUFIXO));
            JasperPrint print = JasperFillManager.fillReport(file.getAbsolutePath(), params, connection);
            bytes = JasperExportManager.exportReportToPdf(print);

        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
            System.out.println("MMMEEENNNSSAAAGGEEEMMM: "+ e.getMessage());
        }

        return bytes;
    }


}
