package com.azcodeur.nectar.Model;

import android.view.TextureView;
import android.widget.ImageView;
import android.widget.TextView;

public class SliderModel {
    private String imgPic;
    private String titre, description;

    public SliderModel() {}

    public SliderModel(String imgPic, String titre, String description) {
        this.imgPic = imgPic;
        this.titre = titre;
        this.description = description;
    }

    public String getImgPic() {
        return imgPic;
    }

    public void setImgPic(String imgPic) {
        this.imgPic = imgPic;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
