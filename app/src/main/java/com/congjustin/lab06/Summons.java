package com.congjustin.lab06;

public class Summons {
    private String[] fiveStars, fiveStarsf, fourStars,  fourStarsf, threeStars;
    private int pityCount5;
    private int pityCountf5;
    private int pityCount4;

    public void setPityCount5(int pityCount5) {
        this.pityCount5 = pityCount5;
    }

    public void setPityCountf5(int pityCountf5) {
        this.pityCountf5 = pityCountf5;
    }

    public void setPityCount4(int pityCount4) {
        this.pityCount4 = pityCount4;
    }

    public void setPityCountf4(int pityCountf4) {
        this.pityCountf4 = pityCountf4;
    }

    private int pityCountf4;
    private final int PITYMAX5 = 89;
    private final int PITYMAX4 = 9;
    public Summons()
    {
        fiveStars = new String[]{"Diluc", "Mona", "Keqing", "Qiqi", "Jean"};
        fourStars = new String[]{"Amber", "Beidou", "Bennett", "Chongyun", "Kaeya", "Lisa", "Ningguang", "Noelle", "Razor", "Sucrose", "Xingqiu"};
        threeStars = new String[]{"Garbage"};
        fiveStarsf = new String[]{"Venti"};
        fourStarsf = new String[]{"Barbara", "Fischl", "Xiangling"};
        pityCount4 = 0;
        pityCount5 = 0;
        pityCountf5 = 0;
        pityCountf4 = 0;
    }
    public String[] drawSingle() {
        double roll = Math.random();
        int ifFeatured = (int) (Math.random() * 2);//1 is featured, 0 is unfeatured
        if (pityCount5 == PITYMAX5) {
            pityCount5 = pityCount4 = 0;
            if (pityCountf5 == 1 || ifFeatured == 1){
                pityCountf5 = 0;
                return new String[]{random(fiveStarsf)};}
            else if (ifFeatured == 0) {
                pityCountf5++;
                return new String[]{random(fiveStars)};
            }
        }
        else if (pityCount4 == PITYMAX4) {
            pityCount4 = 0;
            pityCount5++;
            if (pityCountf4 == 1 || ifFeatured == 1){
                pityCountf4 = 0;
                return new String[]{random(fourStarsf)};}
            else if (ifFeatured == 0) {
                pityCountf4++;
                return new String[]{random(fourStars)};
            }
        }
        else if (roll < 0.006){
            pityCount5 = pityCount4 = 0;
            if (ifFeatured == 0){
                pityCountf5++;
                return new String[]{random(fiveStars)};
            }
            else {
                pityCountf5 = 0;
                return new String[]{random(fiveStarsf)};
            }
        }
        else if (roll < 0.051) {
            pityCount4 = 0;
            pityCount5++;
            if (ifFeatured == 0){
                pityCountf4++;
                return new String[]{random(fourStars)};
            }
            else {
                pityCountf4 = 0;
                return new String[]{random(fourStarsf)};
            }
        }
        else {
            pityCount4++;
            pityCount5++;
            return new String[]{random(threeStars)};
        }
        return new String[]{};
    }
    public String[] drawMulti() {
        String[] a = drawSingle();
        String[] b = drawSingle();
        String[] c = drawSingle();
        String[] d = drawSingle();
        String[] e = drawSingle();
        String[] f = drawSingle();
        String[] g = drawSingle();
        String[] h = drawSingle();
        String[] i = drawSingle();
        String[] j = drawSingle();
        String[] temp = new String[a.length + b.length + c.length + d.length + e.length + f.length + g.length + h.length + i.length + j.length];
        int count = 0;
        for (int x = 0; x < a.length; x++){
            temp[x] = a[x];
            count ++;
        }
        for (int x = 0; x < b.length; x++){
            temp[count] = b[x];
            count ++;
        }
        for (int x = 0; x < c.length; x++){
            temp[count] = c[x];
            count ++;
        }
        for (int x = 0; x < d.length; x++){
            temp[count] = d[x];
            count ++;
        }
        for (int x = 0; x < e.length; x++){
            temp[count] = e[x];
            count ++;
        }
        for (int x = 0; x < f.length; x++){
            temp[count] = f[x];
            count ++;
        }
        for (int x = 0; x < g.length; x++){
            temp[count] = g[x];
            count ++;
        }
        for (int x = 0; x < h.length; x++){
            temp[count] = h[x];
            count ++;
        }
        for (int x = 0; x < i.length; x++){
            temp[count] = i[x];
            count ++;
        }
        for (int x = 0; x < j.length; x++){
            temp[count] = j[x];
            count ++;
        }
        return temp;
    }
    private String random(String[] array) {
        return array[(int)(Math.random() * array.length)];
    }
}
