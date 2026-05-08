package com.ninni.dye_depot.data;

import net.minecraft.DetectedVersion;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;

public class DDPackMetadata extends PackMetadataGenerator {

    public DDPackMetadata(PackOutput output, Component description) {
        super(output);
        add(PackMetadataSection.CLIENT_TYPE, new PackMetadataSection(
            description,
            new InclusiveRange<>(DetectedVersion.BUILT_IN.packVersion(PackType.CLIENT_RESOURCES))
        ));
    }

}
