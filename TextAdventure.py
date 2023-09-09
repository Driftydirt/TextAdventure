from enemy import Enemy
from player import Player
from weapon import Weapon
import random

weaponList = []
weaponList.append(Weapon("Storm Bolter", 0, 2))
weaponList.append(Weapon("Power Fist", 2, 1))
player = Player("Space Marine", 10, 4, weaponList)

def intro():
    directions = ["left", "right", "forward"]
    print("Upon boarding the space hulk, you emerge into a relatively familiar scene.")
    print("The corridor of a Gothic-class cruiser greets you.")
    print("A few paces ahead there is a crossroad in the path.")
    
    missionOver = False
    while not missionOver:
        userInput = ""
        while userInput not in directions:
            print("You can continue forward, or turn either left, or right.")
            userInput = input()
            if userInput == "left":
                print("You turn left")
                combat("termigant", 1)
            elif userInput == "right":
                print("You turn right")
                combat("termigant", 1)
            elif userInput == "forward":
                print("You continue forward")
                combat("termigant", 1)


def combat(enemy, quantity):
    print("Your Auspex shows a blip ahead, 'Enemy detected!'")
    print("Charging towards you is " + str(quantity) + " " + enemy)
    enemy = Enemy(enemy, 2, 2, Weapon("Claws", 1, 1))
    actions = ["storm bolter", "power fist"]
    combatOver = False
    while not combatOver:
        userInput = ""

        while userInput not in actions:
            print("You can either shoot your storm bolter, or swing your power fist")

            userInput = input()
            if userInput == "storm bolter":
                outcome = attack(enemy, player.weapon[0])
                if outcome == "dead":
                    combatOver = True
            elif userInput == "power fist":
                outcome = attack(enemy, player.weapon[1])
                if outcome == "dead":
                    combatOver = True
        

def attack(enemy, weapon):
    print("You attack with " + weapon.name + ".")
    attackRoll = random.randint(1,6)
    attackRoll = attackRoll + weapon.accuracy
    outcome = "living"
    if attackRoll > enemy.ac:
        print("Your attack lands and causes damage.")
        outcome = enemy.lowerHP(weapon.dmg)
        print("The " + enemy.name + " is " + outcome)
    else:
        print("Your attack misses.")
    if outcome == "living":
        print(str(enemy.HP) + "HP remaining")
        return
    return outcome


if __name__ == "__main__":
    while True:
        print("Welcome Brother!")
        print("May the God-Emperor Bless You!")
        print("What is your name, brother?")
        name = input()
        print("Welcome to the chapter, " + name + "!")
        print("The mission is to breach a infernal space hulk and cleanse it of filthy xenos.")
        print("Good luck brother.")
        intro()
