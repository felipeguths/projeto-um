package br.com.felipeaulas.projetoum.car;

public enum CarBrand {
    RENAULT{
        @Override
        public String getDiscount() {
            return "10%";
        }
    }, VOLKS {
        @Override
        public String getDiscount() {
            return "15%";
        }
    }, FIAT {
        @Override
        public String getDiscount() {
            return "20%";
        }
    }, FORD {
        @Override
        public String getDiscount() {
            return "25%";
        }
    };

    public abstract String getDiscount();
}
