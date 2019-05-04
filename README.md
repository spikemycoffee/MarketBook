Group Project - README Template
===

# MarketBook

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
A social media app to connect anyone in the world of real estate based on specific areas of real estate.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Social Media/Real Estate
- **Mobile:** This app has a focus on mobile but can extend to computers as well. It would not be limited to mobile, but mobile would be more convenient
- **Story:** User can view real estate through a map and find other users online who are also interested in that same real estate and create a sort of investment group. In addition the user does not have to invest and can befriend other real estate fanatics and message one another all things real estate.
- **Market:** Open to homeowners, real estate agents, and those who just want to network and learn.
- **Habit:** The app usage will depend on how seriously involved the user will be.
- **Scope:** First the focus will just be users can scout the areas of real estate and connect with other users based on interest. In the future this app could be used for serious real estate investment groups who could actually securely pool money together in their group with members across the world.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**
- [x] Users can view intro slider before sign up
- [x] Users can sign up & login.
- [x] Users can access the navigational bar 
- [ ] Users can add their homes to the application for sell
- [ ] Users can make groups
- [ ] Groups can make polls and vote for houses
- [ ] Users can chat with their groups in a chatbox
- [ ] Groups can poll money 
- [ ] Groups can make transactions with home owners and claim ownership 
- [ ] Users profile has current listings, houses they placed for rent and current investments
- [ ] Users can view their timeline for houses that are newly placed, brought, or posted
- [ ] User can browse the map for all available real estate and save them.

**Optional Nice-to-have Stories**
- [ ] Account verification with legal documentation
- [ ] Integrate account with phone numbers
- [ ] Users can save list of contacts
- [ ] Users can search for houses brought by groups to invest
- [ ] Account verification with legal documents
- [ ] Suggest friends via phone contacts
- [ ] Integrate Attom api to search for points of interest / schools / neighbord 

### 2. Screen Archetypes

* Login 
* Register - User signs up or logs into their account
* Map Screen
   * Available real estate with its information can be seen
* Profile Screen 
   * Allows user to share what real estate they are interested in along with a note
* Real estate group
   * Allows user to create a group based on a specific real estate and can add other users to the group to chat with
* Settings Screen
   * Lets user change language, and app notification settings.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Map
* real estate groupchat
* Settings

**Flow Navigation** (Screen to Screen)

* Forced Log-in -> Account creation if no log in is available
* Map Selection-> Information about specific available real estate
* Real Estate Group -> Create chat with specified real estate and add other users
* Profile -> List of real estate interest
* Settings -> Toggle settings

## Digital Wireframes & Mockups

<img src="https://github.com/spikemycoffee/MarketBook/blob/master/wireframes.gif">

Click [here](https://xd.adobe.com/spec/09e4203c-66e5-48b2-7ede-5ecc6d90c3d0-7fd5/) to view the digital wireframe and interaction flow

### Interactive Prototype

<img src="https://github.com/spikemycoffee/MarketBook/blob/master/walkthrough.gif">

Click [here](https://xd.adobe.com/view/d6ce73c7-a1a7-4104-710c-2b66a086d13e-a0ff/) to see interactive prototype


GIF created with [LiceCap](https://www.cockos.com/licecap/)

## Schema 

### Models

#### User Class
| Property      | type          |  Description  |
| ------------- |:-------------:| -----|
| User Name     | String        | The users Display name |
| Password      | String        | Users login Password |
| Listing       | Array<E>      | An array of house listing |
| Groups        | Relation      | Array of pointers to Group table class |
| Wallet        | Integer       | The amount of money the users holds |
| Invested      | Integer       | The amount of money the user has invested 
| Contacts      | Relation      | Array of pointers to the Users class username |


#### Group Class / Chat
| Property      | type          |  Description  |
| ------------- |:-------------:| -----|
| Group Name    | String        | The name of the group |
| Users         | Relation      | Array of pointers to the Users class |
| Investment Poll | Array<E>    | Array of poll objects (potential investments) |
| Money polled  | Integer       | The amount of money the group has polled for investments |
| Invested Poll | Integer       | The amount of money the group has investmented |


#### Messages Class
| Property      | type          |  Description  |
| ------------- |:-------------:| -----|
| User          | Pointer       | A pointer to the users id corresponding to their messages |
| Body          | String        | The message the user sends |
| GroupId       | Pointer       | Points the group that the messge belongs to |


#### Post Class
| Property      | type          |  Description  |
| ------------- |:-------------:| -----|
| User          | Pointer       | The user id for the post  |
| Text          | String        | The text for the post |
| Image         | File          | Parse file that saves the images |
| reposts       | Integer       | The amount of times it got reposted |
| Comments      | Relation      | Array of points the Post Class |
| Likes         | Integer       | The amount of likes |

[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
