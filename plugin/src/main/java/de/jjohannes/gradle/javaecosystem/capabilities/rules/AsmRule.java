package de.jjohannes.gradle.javaecosystem.capabilities.rules;

import org.gradle.api.artifacts.CacheableRule;
import org.gradle.api.artifacts.ComponentMetadataContext;
import org.gradle.api.artifacts.ComponentMetadataRule;

@CacheableRule
public abstract class AsmRule implements ComponentMetadataRule {

    public static final String CAPABILITY_GROUP = "asm";
    public static final String CAPABILITY_NAME = "asm";

    public static final String[] MODULES = {
            "org.ow2.asm:asm"
    };

    @Override
    public void execute(ComponentMetadataContext context) {
        String version = context.getDetails().getId().getVersion();
        context.getDetails().allVariants(variant -> variant.withCapabilities(capabilities -> capabilities.addCapability(
                CAPABILITY_GROUP, CAPABILITY_NAME, version
        )));
    }
}
