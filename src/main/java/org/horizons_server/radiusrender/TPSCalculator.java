package org.horizons_server.radiusrender;

public class TPSCalculator {

    private int TPS;

    public TPSCalculator(RadiusRender plugin) {
        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            long currentSecond;
            long calculatingSecond = System.currentTimeMillis();
            int ticksPerformedInSecond = 0;

            @Override
            public void run() {
                currentSecond = System.currentTimeMillis() / 1000;

                if (currentSecond == calculatingSecond) { // Same second
                    ticksPerformedInSecond ++;
                } else { // Different second
                    TPS = ticksPerformedInSecond;
                    ticksPerformedInSecond = 0;
                    calculatingSecond = currentSecond;
                }
            }
        }, 0, 1);
    }

    public int getTPS() {
        return this.TPS;
    }
}
