from character import Character

class Enemy(Character):
     def __init__(self, name, HP, ac, weapon):
            super().__init__(name, HP, ac, weapon)
