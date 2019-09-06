package dev.anullihate.envyskyblockcore;

import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;
import dev.anullihate.envyskyblockcore.listeners.PlayerEventListener;

public class Core extends PluginBase {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new PlayerEventListener(this), this);


        this.initialize();
    }

    public void initialize() {
        for (Level level : this.getServer().getLevels().values()) {
            if (level.getName().equals("skyblockhub")) {
                level.checkTime();
                level.setTime(Level.TIME_MIDNIGHT);
                level.stopTime();
                level.checkTime();
            } else {
                level.checkTime();
                level.startTime();
                level.checkTime();
            }
        }
    }
}
