package com.example.akash.orientationproject;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView portView;
    ListView landView;
    TextView portAlias;
    TextView portStrength;
    TextView portWeakness;
    TextView landText;
    int selected = 0;
    int  begin = 0;

    public static final String beg = "beg";
    public static final String Hero_Key = "saved";
    public static final String select = "select";
    ArrayList<SuperHero> heros = new ArrayList<SuperHero>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        portView = (ListView)findViewById(R.id.portList);
        landView = (ListView)findViewById(R.id.landList);
        portAlias = (TextView)findViewById(R.id.portAlias);
        portStrength = (TextView)findViewById(R.id.portStrength);
        portWeakness = (TextView)findViewById(R.id.portWeak);
        landText = (TextView)findViewById(R.id.landDes);

        heros.add(new SuperHero("Superman", "Clark Kent", "Super Strength", "Kryptonite", R.drawable.superman,
                "Superman is the most powerful superhero on the planet Earth. He is an alien from the planet Krypton. His alien name is Kal-El but his human name is Clark Kent. He was sent away from planet Krypton be the planet was about to explode. When he landed on Earth, he was adopted by a couple who raised him in Smallville, Kansas, and later became a superhero. He receives his powers because of the yellow sun on planet earth opposed to the red sun on planet Krypton. As a result, he has powers like incredible strength, speed, flight and various other superpowers which he uses to fight evil and protect the innocent. As Clark Kent, he is a reporter working for the Daily Planet in Metropolis. He is a founding member of the Justice League of America."));
        heros.add(new SuperHero("Batman", "Bruce Wayne", "Rich", "Orphan", R.drawable.batman,
                "Batman is the protector of Gotham City. He fights crime and strikes terror into the hearts of criminals in the city while dressed like a bat. Bruce Wayne, Batman’s real identity, is a  billionaire industrialist and notorious playboy. Although he has no superhuman powers, he is one of the world's smartest detective and an incredible fighters. With the help of super advanced gadgets and technical ingenuity, he is an incredibly dangerous opponent. As a result, he can face the most notorious criminals of Gotham city like Joker, Scarecrow etc. He is also a founding member of the Justice League."));
        heros.add(new SuperHero("Wonder Woman", "Diana Prince", "Daughter of Zeus", "None", R.drawable.wonderwoman,
                "Wonder Woman is an Amazonian warrior princess from a secret place called Themyscira. She is the daughter of Hippolyta, so she was given powers by the Gods to fight against evil. She was raised entirely by women on the island of Themyscira and was sent as an ambassador to the Man's World. Wonder Woman fights crime and acts as a positive role model for women everywhere in the world. Her magical weapons includes the Lasso of Truth, magic gauntlets, and a special sword. Her secret Identity, Diana Prince, allows her to closely interact with people around her. Wonder Woman is also a founding member of the Justice League of America."));
        heros.add(new SuperHero("The Flash", "Barry Allen", "Super Speed", "Speed-Force", R.drawable.flash,
                "The Flash, also known as Barry Allen is the fastest man alive. He has the power of super-speed by tapping into the Speed Force. He uses his powers to fight crime and save the innocent. His is the second person in the family to possess super speed, making him a successor to the original Jay Garrick and a predecessor to Wally West. While he is not fighting crime as the scarlet speedster, Barry Allen is a Crime Scene Investigator at Central City Police Department. He is also one of the founding member of the Justice League of America."));
        heros.add(new SuperHero("Aquaman", "Arthur Curry", "Water Abilities", "Water Deprivation", R.drawable.aquaman,
                "Aquaman, the King of Atlantis, with incredible strength and swimming as well as the ability to command sea-life. He is able to survive both on land and deep ocean waters in depths of high pressure and low temperature. His Atlantean name is Orin and his human name is Arthur Curry. He fights to protect both worlds by using his amazing abilities and wisdom. He is another founding member of the Justice League of America." ));
        heros.add(new SuperHero("Cyborg", "Victor Stone","Technology", "Human Aspects", R.drawable.cyborg,
                "Cyborg, also known as Victor Stone, is half man and half machine. His body was destroyed in a tragic accident, but he was saved by his dad who used alien tech to replace his body parts. This new alien technology contains a large arsenal of high-tech gadgets and weaponry, while providing life support at the same time. He has primarily been a member of the Teen Titans, but he is also a member of the Justice League. "));
        heros.add(new SuperHero("Green Lantern", "Hal Jordan", "Green Lantern Ring", "Color Yellow", R.drawable.greenlantern,
                "Green Lantern is a mantle picked up various people. Hal Jordan was the first human ever inducted into the Green Lantern Corps, and has been heralded as possibly the greatest Green Lantern of all time. He gets his power from the powerful Green ring of the Green Lantern Corps. The ring gives him access to any power he desires. His only limit is his thought. Besides the mantle of Green Lantern, Hal Jordan is also a fighter pilot. He is also a founding member of the Justice League of America. " ));
        heros.add(new SuperHero("Martian Manhunter", "John Jones", "Earth", "Fire", R.drawable.martian,
                "Martian Manhunter, also known as J'onn J'onzz or John Jones, is the last surviving member of planet mars. The civil war between green martians and the white martians killed his wife and daughter, and his entire race. Luckily he was able to escape to Earth and survive.His natural abilities include super-strength, super-speed, invulnerability, flight, shape-shifting, intangibility and telepathy. In his secret identity, to blend into humanity, he is a gritty hard-boiled police officer. He is also a member of the Justice League of America."));
        heros.add(new SuperHero("Green Arrow", "Oliver Queen", "Rich", "mortality", R.drawable.arrow,
                "Green Arrow, a vigilante superhero, fights crime using archery, martial arts and technology. Similar to Batman, Oliver Queen, living in Star City is a wealthy playboy and billionaire industrialist who eventually became a politician. He fights crime In Star City along with a group of Sidekicks/Heroes some of which include, Black Canary and Speedy. He is also a member of the Justice League of America."));
        heros.add(new SuperHero("Captain Marvel", "Billy Batson", "Super Strength", "Magic Attack", R.drawable.shazam,
                "Captain Marvel also known as Shazam, i s a superhero with magical origins. He was chosen to be a champion for good by the powerful wizard Shazam, and gains incredible powers whenever he speaks the wizard's name. In his secret identity he is young Billy Batson, an idealistic news reporter working in Fawcett City, but when he speaks the name shazam he transforms into his fully-grown heroic persona. The powers he has been granted include S for the wisdom of Solomon, H for the strength of Hercules, A for the stamina of Atlas, Z for the power of Zeus, A for the courage of Achilles, and M for the speed of Mercury. Basically, he has super strength and speed similar to superman."));

        if(savedInstanceState!=null){
            heros = (ArrayList<SuperHero>) savedInstanceState.getSerializable(Hero_Key);
            selected = savedInstanceState.getInt(select);
        }

        if(portView!=null){
            CustomAdapter adapter = new CustomAdapter(this,R.layout.adapters,heros);
            portView.setAdapter(adapter);
            if(begin>0){
            portAlias.setText("Alias: "+heros.get(selected).getAlias());
            portStrength.setText("Strength: "+heros.get(selected).getPower());
            portWeakness.setText("Weakness: "+heros.get(selected).getWeak());
            }
            portView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    selected = i;
                    begin++;
                    portAlias.setText("Alias: "+heros.get(i).getAlias());
                    portStrength.setText("Strength: "+heros.get(i).getPower());
                    portWeakness.setText("Weakness: "+heros.get(i).getWeak());
                }
            });

        }

        if(landView!=null) {
            CustomAdapter adapter = new CustomAdapter(this,R.layout.adapters,heros);
            landView.setAdapter(adapter);
            if (begin>0){
                if(landText!=null)
            landText.setText("Alias: "+heros.get(selected).getAlias()+"\n"+"Strength: "+heros.get(selected).getPower()+"\n"+"Weakness: "+heros.get(selected).getWeak()+"\n\n\t"+heros.get(selected).getBio());
            }
            landView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    selected = i;
                    begin++;
                    landText.setText("Alias: "+heros.get(i).getAlias()+"\n"+"Strength: "+heros.get(i).getPower()+"\n"+"Weakness: "+heros.get(i).getWeak()+"\n\n\t"+heros.get(i).getBio());
                }
            });
            landText.setMovementMethod(new ScrollingMovementMethod());
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(Hero_Key,heros);
        outState.putInt(select, selected);
        outState.putInt(beg, begin);
    }

    public class CustomAdapter extends ArrayAdapter<SuperHero> {
        Context context;
        List list;

        public CustomAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<SuperHero> objects){
            super(context, resource, objects);
            this.context = context;
            list = objects;
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterView = layoutInflater.inflate(R.layout.adapters,null);

            TextView textView = adapterView.findViewById(R.id.Name);
            ImageView picture = adapterView.findViewById(R.id.picture);
            Button button = adapterView.findViewById(R.id.Remove);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    heros.remove(position);
                    notifyDataSetChanged();
                }
            });

            textView.setText(heros.get(position).getName());
            picture.setImageResource(heros.get(position).getPic());
            return adapterView;
        }

    }
}