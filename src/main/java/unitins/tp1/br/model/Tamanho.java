package unitins.tp1.br.model;

public enum Tamanho {
    M10(1, "10M"),
    M20(2, "20M"),
    M30(3, "30M"),
    M40(4, "40M"),
    M50(5, "50M"),
    M60(6, "60M"),
    M70(7, "70M"),
    M80(8, "80M"),
    M90(9, "90M"),
    M100(10, "100M"),
    M120(11, "120M"),
    M140(12, "140M"),
    M130(13, "130M");

    private final int ID;
    private final String TAMANHO;

    Tamanho(int id, String tamanho) {
        this.ID = id;
        this.TAMANHO = tamanho;
    }

    public int getId() {
        return ID;
    }

    public String getTAMANHO() {
        return TAMANHO;
    }

    public static Tamanho valueOf(long id) {
        for (Tamanho r : Tamanho.values()) {
            if (r.getId() == id)
                return r;
        }
        return null;
    }

}
