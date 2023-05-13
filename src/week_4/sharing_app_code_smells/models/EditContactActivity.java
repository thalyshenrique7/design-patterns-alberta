package week_4.sharing_app_code_smells.models;

public class EditContactActivity extends AppCompatActivity implements Observer {

    private ContactList contact_list = new ContactList();
    private ContactListController contact_list_controller = new ContactListController(contact_list);

    private Contact contact;
    private ContactController contact_controller;

    private EditText email;
    private EditText username;

    private String email_str;
    private String username_str;

    private Context context;
    private int pos;
    private boolean on_create_update = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Intent intent = getIntent();
        pos = intent.getIntExtra("position", 0);

        context = getApplicationContext();
        contact_list_controller.addObserver(this);
        contact_list_controller.loadContacts(context);
        on_create_update = false;
    }

    public void saveContact(View view) {

        email_str = email.getText().toString();
        username_str = username.getText().toString();

        if(!validateInput()) return;

        String id_str = contact_controller.getId();
        Contact updated_contact = new Contact(username_str, email_str, id_str);

        boolean success = contact_list_controller.editContact(contact, updated_contact, context);
        if (!success) {
            return;
        }

        finish();
    }

    public boolean validateInput() {
        if (username_str.equals("")) {
            username.setError("Empty field!");
            return false;
        }

        if (!email_str.contains("@")) {
            email.setError("Must be an email address!");
            return false;
        }

        if (!contact_list_controller.isUsernameAvailable(username_str) &&
                !(contact.getUsername().equals(username_str))){
            username.setError("Username already taken!");
            return false;
        }

        return true;
    }

    public void deleteContact(View view) {

        boolean success = contact_list_controller.deleteContact(contact, context);
        if (!success) {
            return;
        }

        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contact_list_controller.removeObserver(this);
    }

    public void update(){

        if (on_create_update) {

            contact = contact_list_controller.getContact(pos);
            contact_controller = new ContactController(contact);

            username = (EditText) findViewById(R.id.username);
            email = (EditText) findViewById(R.id.email);

            username.setText(contact_controller.getUsername());
            email.setText(contact_controller.getEmail());
        }
    }
}
