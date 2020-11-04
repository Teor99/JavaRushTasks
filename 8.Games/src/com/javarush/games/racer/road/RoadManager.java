package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.PlayerCar;
import com.javarush.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private static final int PLAYER_CAR_DISTANCE = 12;
    private List<RoadObject> items = new ArrayList<>();
    private int passedCarsCount = 0;

    public int getPassedCarsCount() {
        return passedCarsCount;
    }

    private boolean isRoadSpaceFree(RoadObject object) {
        for (RoadObject roadObject : items) {
            if (roadObject.isCollisionWithDistance(object, PLAYER_CAR_DISTANCE)) {
                return false;
            }
        }

        return true;
    }

    public boolean checkCrush(PlayerCar playerCar) {
        for (RoadObject roadObject : items) {
            if (roadObject.isCollision(playerCar)) {
                return true;
            }
        }

        return false;
    }

    private void deletePassedItems() {
        for (int i = 0; i < items.size(); ) {
            if (items.get(i).y >= RacerGame.HEIGHT) {
                if (items.get(i).type != RoadObjectType.THORN) {
                    passedCarsCount++;
                }
                items.remove(i);
            } else {
                i++;
            }
        }
    }

    public void generateNewRoadObjects(Game game) {
        generateThorn(game);
        generateRegularCar(game);
        generateMovingCar(game);
    }

    private void generateThorn(Game game) {
        if (game.getRandomNumber(100) < 10 && !isThornExists()) {
            addRoadObject(RoadObjectType.THORN, game);
        }
    }

    private boolean isThornExists() {
        for (RoadObject roadObject : items) {
            if (roadObject.type == RoadObjectType.THORN) {
                return true;
            }
        }

        return false;
    }

    public void draw(Game game) {
        for (RoadObject roadObject : items) {
            roadObject.draw(game);
        }
    }

    public void move(int boost) {
        for (RoadObject roadObject : items) {
            roadObject.move(roadObject.speed + boost, items);
        }

        deletePassedItems();
    }

    private void addRoadObject(RoadObjectType type, Game game) {
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);

        RoadObject newRoadObject = createRoadObject(type, x, y);
        if (isRoadSpaceFree(newRoadObject)) {
            items.add(newRoadObject);
        }
    }

    private boolean isMovingCarExists() {
        for (RoadObject roadObject : items) {
            if (roadObject.type == RoadObjectType.DRUNK_CAR) {
                return true;
            }
        }

        return false;
    }

    private RoadObject createRoadObject(RoadObjectType type, int x, int y) {
        if (type == RoadObjectType.THORN) {
            return new Thorn(x, y);
        } else if (type == RoadObjectType.DRUNK_CAR) {
            return new MovingCar(x, y);
        }

        return new Car(type, x, y);
    }

    private void generateRegularCar(Game game) {
        int carTypeNumber = game.getRandomNumber(4);
        if (game.getRandomNumber(100) < 30) {
            addRoadObject(RoadObjectType.values()[carTypeNumber], game);
        }
    }

    private void generateMovingCar(Game game) {
        if (game.getRandomNumber(100) < 10 && !isMovingCarExists()) {
            addRoadObject(RoadObjectType.DRUNK_CAR, game);
        }
    }
}
