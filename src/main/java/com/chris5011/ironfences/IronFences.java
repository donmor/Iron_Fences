package com.chris5011.ironfences;

import com.chris5011.ironfences.proxy.ClientProxy;
import com.chris5011.ironfences.proxy.IProxy;
import com.chris5011.ironfences.proxy.ServerProxy;
import com.chris5011.ironfences.setup.ClientSetup;
import com.chris5011.ironfences.setup.ModSetup;
import com.chris5011.ironfences.setup.Registry;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("ironfences")
public class IronFences {

    public static final String MODID = "ironfences";
    public static IProxy proxy = DistExecutor.unsafeRunForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public IronFences() {

        //Launch the registration of all Items and Blocks
        Registry.registerRegistries();

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::setup);

        //Register the clientsetup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientSetup::clientInit);
    }
}
