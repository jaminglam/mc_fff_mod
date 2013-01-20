package fff;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fff.blocks.BlockClover;
import fff.blocks.BlockTuzki;
import fff.entities.EntityButterflyShot;
import fff.generators.GeneratorClover;
import fff.items.ItemCirno;
import fff.items.ItemTreeAxeGod;
import fff.items.ItemTreeAxeIron;
import fff.items.ItemYuyukoFan;
import fff.proxy.Proxy;

@Mod(modid = "FFF", name = "FFF", version = "1.1.1.4")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class FFFMOD {
	
	@Instance("FFF")
	public static FFFMOD instance;
	
	@SidedProxy(clientSide = "fff.proxy.ClientProxy", serverSide = "fff.proxy.Proxy")
	public static Proxy proxy;
	
	final public static int RENDER_TYPE_BLOCK_CLOVER = 502;
	
	public static Block block_tuzki = new BlockTuzki(501);
	public static Block block_clover = new BlockClover(502);
	
	public static Item item_ciron = new ItemCirno(10001); // ��� 32000
	public static Item item_tree_axe_iron = new ItemTreeAxeIron(10002);
	public static Item item_tree_axe_god = new ItemTreeAxeGod(10003);
	
	public static Item item_test = new ItemYuyukoFan(20000);
	
	@Init
	public void init(FMLInitializationEvent event) {
		proxy.init();
				
		ModLoader.registerBlock(block_tuzki);
		ModLoader.addName(block_tuzki, "��˹������");
		
		ModLoader.registerBlock(block_clover);
		ModLoader.addName(block_clover, "��Ҷ��");
		
		ModLoader.addName(item_ciron, "��¶ŵ����");
		
		ModLoader.addName(item_tree_axe_iron, "������ͷ");
		ModLoader.addRecipe(new ItemStack(item_tree_axe_iron), new Object[] {
			"BBC",
			"BA ",
			"BA ",
			Character.valueOf('B'), Item.ingotIron,
			Character.valueOf('A'), Item.stick,
			Character.valueOf('C'), Block.blockSteel
		});
		
		ModLoader.addName(item_tree_axe_god, "Դ��봽���ڤȼ��а���Ӽ����񸫡���");
		
		ModLoader.addName(item_test, "����ħ����");
		
		// ���δ�����
		GameRegistry.registerWorldGenerator(new GeneratorClover());
		
		EntityRegistry.registerGlobalEntityID(EntityButterflyShot.class, "ButterflyShot", 541);
		EntityRegistry.registerModEntity(EntityButterflyShot.class, "ButterflyShot", 11, this, 250, 5, true);
	}
}
