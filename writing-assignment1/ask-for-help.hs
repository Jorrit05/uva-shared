type Name = String
type Relation = Name
type ParentName = Name
type Child = (Name, ParentName)
type Holder = Name
type Claimant =  Name
type ChildName = Name
type Parent = (Name, ChildName)

isViolated :: (a -> Bool) -> a -> Bool
isViolated p x | p x  = True
               | otherwise = False

isLegalParent ::  Child -> Parent -> Bool
isLegalParent c p | fst c == snd p && fst p == snd c = True
                  | otherwise = False

createHomeworkDuty ::  Child -> Parent -> (Holder, Claimant, (a -> Bool) -> a -> Bool)
createHomeworkDuty c p = (fst p, fst c, isViolated)

askForHelp :: Child -> Parent -> Maybe (Holder, Claimant, (a -> Bool) -> a -> Bool)
askForHelp c p | isLegalParent c p = Just $ createHomeworkDuty c p
               | otherwise = Nothing
