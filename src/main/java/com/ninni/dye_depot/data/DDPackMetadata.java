package com.ninni.dye_depot.data;

import com.ninni.dye_depot.DyeDepot;
import net.minecraft.DetectedVersion;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;

public class DDPackMetadata extends PackMetadataGenerator {

    public DDPackMetadata(PackOutput output, String description) {
        super(output);
        add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal(description),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES)
        ));
    }

}
