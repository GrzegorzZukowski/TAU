package pl.zukowski.tau.labone.domain;

import java.util.Date;

public class ObslogaDaty {
    public Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ObslogaDaty(Date data) {
        this.data = data;
    }
}
