package enum1;

public enum Gender implements GenderDesc {
    MALE(0,"男","男人") {
        public void info() {
            System.out.print("我是 Gender类的男士");
        }
    },
    FEMALE(1,"女","女人") {
        public void info() {
            System.out.print("我是 Gender类的女士");
        }
    };
    private final int type ;
    private final String typeName;
    private final String desc;
    Gender( int type,String typeName,String desc) {
        this.type = type;
        this.typeName = typeName;
        this.desc = desc;
    }
}