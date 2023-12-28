package Config;
import java.util.Date;

public class Report {
        public String getReportPath(){
                String reportPath= System.getProperty("user.dir")+"/Reports/Report"+new Date().toLocaleString()+".html";
                return  reportPath;
        }

}
