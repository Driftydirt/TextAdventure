from character import Character

class Player(Character):
    def __init__(self, name, HP, ac, weapon):
            super().__init__(name, HP, ac, weapon)
