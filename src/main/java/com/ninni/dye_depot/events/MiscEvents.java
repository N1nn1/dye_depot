package com.ninni.dye_depot.events;

import com.google.common.collect.Maps;
import com.ninni.dye_depot.DyeDepot;
import com.ninni.dye_depot.registry.DDBlocks;
import com.ninni.dye_depot.registry.DDDyeKeys;
import com.ninni.dye_depot.registry.DDDyes;
import com.ninni.dye_depot.registry.DDItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = DyeDepot.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MiscEvents {
    private static final Map<String, Supplier<ItemLike>> MORE_ITEM_BY_DYE = Util.make(Maps.newHashMap(), (enumMap) -> {
        enumMap.put(DDDyeKeys.MAROON.getName(), DDBlocks.MAROON_WOOL::get);
        enumMap.put(DDDyeKeys.ROSE.getName(), DDBlocks.ROSE_WOOL::get);
        enumMap.put(DDDyeKeys.CORAL.getName(), DDBlocks.CORAL_WOOL::get);
        enumMap.put(DDDyeKeys.INDIGO.getName(), DDBlocks.INDIGO_WOOL::get);
        enumMap.put(DDDyeKeys.NAVY.getName(), DDBlocks.NAVY_WOOL::get);
        enumMap.put(DDDyeKeys.SLATE.getName(), DDBlocks.SLATE_WOOL::get);
        enumMap.put(DDDyeKeys.OLIVE.getName(), DDBlocks.OLIVE_WOOL::get);
        enumMap.put(DDDyeKeys.AMBER.getName(), DDBlocks.AMBER_WOOL::get);
        enumMap.put(DDDyeKeys.BEIGE.getName(), DDBlocks.BEIGE_WOOL::get);
        enumMap.put(DDDyeKeys.TEAL.getName(), DDBlocks.TEAL_WOOL::get);
        enumMap.put(DDDyeKeys.MINT.getName(), DDBlocks.MINT_WOOL::get);
        enumMap.put(DDDyeKeys.AQUA.getName(), DDBlocks.AQUA_WOOL::get);
        enumMap.put(DDDyeKeys.VERDANT.getName(), DDBlocks.VERDANT_WOOL::get);
        enumMap.put(DDDyeKeys.FOREST.getName(), DDBlocks.FOREST_WOOL::get);
        enumMap.put(DDDyeKeys.GINGER.getName(), DDBlocks.GINGER_WOOL::get);
        enumMap.put(DDDyeKeys.TAN.getName(), DDBlocks.TAN_WOOL::get);
    });

    @SubscribeEvent
    public void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof Sheep sheep) {
            if (!sheep.level().isClientSide && sheep.readyForShearing() && event.getItemStack().is(Tags.Items.SHEARS) && sheep.getColor().getId() > 15) {
                sheep.level().playSound(null, sheep, SoundEvents.SHEEP_SHEAR, SoundSource.PLAYERS, 1.0f, 1.0f);
                sheep.setSheared(true);
                int i = 1 + sheep.getRandom().nextInt(3);

                for (int j = 0; j < i; ++j) {
                    ItemEntity itemEntity = sheep.spawnAtLocation(MORE_ITEM_BY_DYE.get(sheep.getColor().getName()).get(), 1);
                    if (itemEntity == null)  continue;
                    itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((sheep.getRandom().nextFloat() - sheep.getRandom().nextFloat()) * 0.1F, (sheep.getRandom().nextFloat() * 0.05F), ((sheep.getRandom().nextFloat() - sheep.getRandom().nextFloat()) * 0.1F)));
                }
                sheep.gameEvent(GameEvent.SHEAR, event.getEntity());
                event.getItemStack().hurtAndBreak(1, event.getEntity(), player -> player.broadcastBreakEvent(event.getHand()));
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
            }
        }
    }

    @SubscribeEvent
    public static void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.CLIENT_RESOURCES) {
            Path resourcePath = ModList.get().getModFileById(DyeDepot.MOD_ID).getFile().findResource("resourcepacks/dye_override");
            Pack pack = Pack.readMetaAndCreate(new ResourceLocation(DyeDepot.MOD_ID, "dye_override").toString(), Component.literal("Dye Override"), false, (path) -> new PathPackResources(path, resourcePath, false), PackType.CLIENT_RESOURCES, Pack.Position.BOTTOM, PackSource.BUILT_IN);
            event.addRepositorySource(packConsumer -> packConsumer.accept(pack));
        }
    }

    @SubscribeEvent
    public void registerVillagerTrades(VillagerTradesEvent event) {
        Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
        if (event.getType() == VillagerProfession.CARTOGRAPHER) {
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BANNER.get()), 12, 15, 0.05f));
        }
        if (event.getType() == VillagerProfession.MASON) {
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_TERRACOTTA.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_TERRACOTTA.get()), 12, 15, 0.05f));
        }
        if (event.getType() == VillagerProfession.SHEPHERD) {
            trades.get(2).add(new BasicItemListing(new ItemStack(DDItems.TAN_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(DDItems.AQUA_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(DDItems.CORAL_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(DDItems.BEIGE_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(DDItems.AMBER_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
        }
        if (event.getType() == VillagerProfession.SHEPHERD) {
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_WOOL.get()),16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_WOOL.get()), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_WOOL.get()), 16, 5, 0.05f));

            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_CARPET.get(), 4), 16, 5, 0.05f));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_CARPET.get(), 4), 16, 5, 0.05f));

            trades.get(3).add(new BasicItemListing(new ItemStack(DDItems.ROSE_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(DDItems.SLATE_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(DDItems.MINT_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(DDItems.FOREST_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(DDItems.GINGER_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));

            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BED.get()), 12, 10, 0.05f));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BED.get()), 12, 10, 0.05f));

            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.MAROON_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.INDIGO_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.TEAL_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD),16, 30, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.VERDANT_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.NAVY_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(DDItems.OLIVE_DYE.get(), 12), ItemStack.EMPTY, new ItemStack(Items.EMERALD), 16, 30, 0.05f));

            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.MINT_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_BANNER.get()), 12, 15, 0.05f));
            trades.get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), ItemStack.EMPTY, new ItemStack(DDItems.TAN_BANNER.get()), 12, 15, 0.05f));
        }
    }

    @SubscribeEvent
    public void registerWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MAROON_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.ROSE_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.CORAL_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.INDIGO_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.NAVY_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.SLATE_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.OLIVE_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AMBER_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.BEIGE_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TEAL_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.MINT_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.AQUA_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.VERDANT_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.FOREST_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.GINGER_DYE.get(), 3), 12, 1, 0.05f));
        genericTrades.add(1, new BasicItemListing(new ItemStack(Items.EMERALD, 1), ItemStack.EMPTY, new ItemStack(DDItems.TAN_DYE.get(), 3), 12, 1, 0.05f));
    }

}
