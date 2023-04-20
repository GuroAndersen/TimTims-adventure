package timtim.app.model.objects.powerup;

import timtim.app.model.objects.CombatEntity;

public class SpeedUp implements Powerup {

    private boolean used;

    public SpeedUp() {
        this.used = false;
    }

    @Override
    public void doPowerupIfActive(CombatEntity entity) {

    }
    
}
