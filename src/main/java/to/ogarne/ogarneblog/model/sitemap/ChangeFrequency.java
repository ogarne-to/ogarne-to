package to.ogarne.ogarneblog.model.sitemap;

/**
 * Site map URL change frequency: provides a hint about how frequently the page is likely to change.
 *
 * @author T-PWK
 */
public enum ChangeFrequency
{
    always, // Use for pages that change every time they are accessed
    hourly,
    daily,
    weekly,
    monthly,
    yearly,
    never; // Use this value for archived URLs
}
