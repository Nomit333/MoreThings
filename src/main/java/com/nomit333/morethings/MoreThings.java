package com.nomit333.morethings;


import com.nomit333.morethings.util.RegistryHandler;
import com.nomit333.morethings.util.RegistryHandlerArmor;
import com.nomit333.morethings.util.RegistryHandlerTools;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("morethings")
public class MoreThings
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "morethings";

    public MoreThings() {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();
        RegistryHandlerTools.init();
        RegistryHandlerArmor.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("MoreThings") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.COPPER_INGOT.get());
        }
     };
}



