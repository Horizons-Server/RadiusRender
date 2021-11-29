package org.horizons_server.radiusrender;

import org.bukkit.plugin.java.JavaPlugin;

public class RadiusRender extends JavaPlugin {
    // https://github.com/webbukkit/dynmap/blob/490948a5ed96255af14fa92e321d99a00c3ad443/DynmapCoreAPI/src/main/java/org/dynmap/DynmapCommonAPI.java#L54

    private TPSCalculator TPSCalculator;

    public static RadiusRender getPlugin() {
        return RadiusRender.getPlugin(RadiusRender.class);
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getCommand("radiusrender").setExecutor(new RenderCommand());
        this.TPSCalculator = new TPSCalculator(this);
    }

    public TPSCalculator getTPSCalculator() {
        return this.TPSCalculator;
    }
}
