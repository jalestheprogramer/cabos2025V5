package unitins.tp1.br.model;

public enum Tecnologia {
    CAT5(1, "Cat-5"),
    CAT6(2, "Cat-6"),
    CAT7(3, "Cat-7"),
    CAT8(4, "Cat-8");

    private final int ID;
    private final String TECNOLOGIA;

    Tecnologia(int id, String tecnologia) {
        this.ID = id;
        this.TECNOLOGIA = tecnologia;
    }

    public int getId() {
        return ID;
    }

    public String getTecnologia(String tecnologia) {
        return TECNOLOGIA;
    }

    public static Tecnologia valueOf(long id) {
        for (Tecnologia r : Tecnologia.values()) {
            if (r.getId() == id)
                return r;
        }
        return null;
    }

}
