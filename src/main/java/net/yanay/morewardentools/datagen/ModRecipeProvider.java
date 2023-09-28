package net.yanay.morewardentools.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.yanay.morewardentools.item.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.WARDEN_ORB, 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .input('#', ModItems.WARDEN_HEART)
                .criterion(hasItem(ModItems.WARDEN_HEART), conditionsFromItem(ModItems.WARDEN_HEART))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WARDEN_ORB)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WARDEN_AXE,1)
                .pattern("SS ")
                .pattern("SH ")
                .pattern(" H ")
                .input('S', ModItems.WARDEN_ORB)
                .input('H', Items.STICK)
                .criterion(hasItem(ModItems.WARDEN_ORB), conditionsFromItem(ModItems.WARDEN_ORB))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.WARDEN_AXE)));
    }
}
