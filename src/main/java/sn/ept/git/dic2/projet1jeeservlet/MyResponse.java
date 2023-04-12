package sn.ept.git.dic2.projet1jeeservlet;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class MyResponse {
    private String msg;

    public MyResponse() {
    }

    public MyResponse(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
