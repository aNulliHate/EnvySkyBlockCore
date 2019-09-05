package dev.anullihate.envyskyblockcore.listeners;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Level;
import cn.nukkit.level.Position;
import dev.anullihate.envyskyblockcore.Core;

public class PlayerEventListener implements Listener {

    private Core core;

    public PlayerEventListener(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setMovementSpeed(0.1f);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Level level = this.core.getServer().getDefaultLevel();
        int x = this.core.getServer().getDefaultLevel().getSafeSpawn().getFloorX();
        int y = this.core.getServer().getDefaultLevel().getSafeSpawn().getFloorY();
        int z = this.core.getServer().getDefaultLevel().getSafeSpawn().getFloorZ();

        if (event.getTo().getFloorY() < 0) {
            event.getPlayer().teleport(new Position(x, y, z, level));
        }
    }
}
