package com.cdp.singleton;

// DCL (Double Checked Locking) or "classic" singleton
public class LazyRegistryWithDCL {

    // faz com que os thread nao utilizem a versao em cache da instancia - forca o read/write
    private static volatile LazyRegistryWithDCL INSTANCE;

    private LazyRegistryWithDCL() {
    }

    public static LazyRegistryWithDCL getInstance() {
        if (INSTANCE == null) {
            // resolve o problema de assincronia, 2 threads poderiam acabar criando 2 instancias
            synchronized (LazyRegistryWithDCL.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazyRegistryWithDCL();
                }
            }
        }
        return INSTANCE;
    }
}
