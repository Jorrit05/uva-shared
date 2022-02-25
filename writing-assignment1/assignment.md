<!-- Author: Rein Spanjer, Bob, Jorrit Stutterheim -->
<!-- Group number: 10 -->
<!-- Student ID Jorrit: 13957899 -->
<!-- Student ID Rein: 13558307 -->
<!-- Study: Premaster software engineering -->
<!-- Course: Programmeer talen -->

# Declarative characteristics

## Question 1

**Describe the parts of the eFLINT language used for defining relations (1 above), manipulating relations (2) and performing inference (3). Do not only list the constructs; describe how they are used to program with relations.**

Relations in eFlint are defined using the following key words:

- Fact: specifies an identity that has relations with other identities.
- Placeholder: does not directly define a relation, but is used later to define complex relations.
- Duty: Identifies a relation between two identities in which there is one party responsible for the duty and another party a claimant for that duty.
- Act: Defines a set of actions between 2 parties that create responsibilities for both parties.

```haskell
Fact person
Placeholder parent    For person
Placeholder child     For person

Fact natural-parent   Identified by parent * child

Domain:
Fact person Identified by Alice, Bob, Chloe, David, Ellis
```

## Question 2

**In eFLINT you can write ?<BOOL-EXPR>., i.e. a question mark followed by a Boolean expression followed by a full stop. Using the terminology of mathematical relations, logic programming, or database programming, what is this construct used for?**

In eFLINT this a boolean expression is used to validate if a Duty or Act has been performed according to the specifications.

A similar statement in logic:

```Lisp
p -> q
```

This construct is used to determine if the state is as expected. After some manipulations the programming can do this checks to be sure that the state is still as expected or that a error has been made. Even in application running in production this can monitor the state of the program.

## Question 3

**What (non-syntactical) differences do you see between the language constructs discussed in the answers to Q1 and Q2 and similar constructs in Prolog or MySQL? Consider, for example, expressive power,or behavior when executed. You can also compare with other logic programming or database languages if you prefer. Be specific.**

EFlint looks like a language that is still in development. It lacks any support for syntax error messages. But the way that you can see all the different states of the program after each query is a nice feature to have.



## Question 4

**Describe the parts of the eFLINT language that can be classified as imperative instructions. Explain how you decided that these are indeed the instructions of the language. For each kind of instruction, explain the effects these instructions can have.**

An imperative instruction is where you describe the flow of the program on how to solve something. In E-Flint a scenario describes a series of actions, events and observations (blz 125)[http://ltvanbinsbergen.nl/files/papers/eflint.pdf].

## Question 5

**What would you say is the state manipulated by an eFLINT program? How does it change overtime? How does the manipulation of state help with assessing a normative (legal) case for compliance?**

# Semantic analysis

## Question 6

**Explain in detail when a duty is considered violated and in which ways a duty can become violated,for example the help-with-homework duty of the ‘Help with Homework’ example. In your explanation you can give and refer to examples. However, your explanation needs to be valid for all duties defined in the language.**

## Question 7

**Argue whether the language is statically or dynamically typed. How did you determine this?**

The language is statically typed. In the frames section it is possible to omit types and even overwrite the types of the different Facts.
But once this stage is successful and these types are used in the scenario these cannot change anymore.

Example:

```Haskell
-- Frames:
Fact myint Identified by Int

-- Scenario:
+myint(1).
+myint(2). // works without line below
+myint("hello world"). // outputs 'technical error'.
```

## Question 8

**Write a C function that implements the ask-for-help act from the ‘Help with Homework’example. The goal is that when this function is called with some arguments, the function behaves like when an instance of the ask-for-help type is triggered. Alternatively: use Haskell, Prolog, MySQL or pseudo-code instead of C.**

```haskell
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
```
